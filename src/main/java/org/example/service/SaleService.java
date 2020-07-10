package org.example.service;

import org.example.domain.Product;
import org.example.domain.Sale;
import org.example.domain.SalePosition;
import org.example.domain.Statistic;
import org.example.repository.ProductRepo;
import org.example.repository.SalePositionRepo;
import org.example.repository.SaleRepo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class SaleService {

    private final SaleRepo saleRepo;
    private final SalePositionRepo salePositionRepo;
    private final ProductRepo productRepo;
    private final StaticService staticService;

    private Integer discount;
    private Product randomProduct;
    private List<SalePosition> salePositions = new ArrayList<>();

    public SaleService(SaleRepo saleRepo, SalePositionRepo salePositionRepo, ProductRepo productRepo, StaticService staticService) {
        this.saleRepo = saleRepo;
        this.salePositionRepo = salePositionRepo;
        this.productRepo = productRepo;
        this.staticService = staticService;
    }

    public void formingSale(SalePosition salePosition) {
        if (getRandomProduct() != null) {
            salePosition.setDiscount(getDiscount());
            salePosition.setDiscountCost(getRandomProduct().getDiscountCost() * salePosition.getCount());
            salePosition.setCost(getRandomProduct().getCost() * salePosition.getCount());
        } else {
            salePosition.setDiscount(0);
            salePosition.setDiscountCost(salePosition.getProduct().getCost() * salePosition.getCount());
            salePosition.setCost(salePosition.getProduct().getCost() * salePosition.getCount());
        }

        salePositions.add(salePosition);
        salePositionRepo.save(salePosition);
    }

    public void addSale() {
        if (!salePositions.isEmpty()) {
            List<SalePosition> temp = new ArrayList<>();

            // Пробовал сделать
//            for (SalePosition sp : salePositions) {
//                if (sp.getProduct().equals(saleRepo.findById(sp.getProduct().getId()))) {
//                    temp.add(sp);
//                }
//            }
//            Но к успеху не пришел.

            for (SalePosition salePosition : salePositionRepo.findAll()) {
                for (SalePosition sp : salePositions) {
                    if (sp.getId().equals(salePosition.getId())) {
                        temp.add(salePosition);
                    }
                }
            }

            Sale sale = new Sale(temp);

            double totalDiscount = 0.0;
            double totalCost = 0.0;

            for (SalePosition sp : temp) {
                totalCost += sp.getCost();
                totalDiscount += sp.getDiscountCost();
            }

            sale.setTotalCostDiscountSales(totalDiscount);
            sale.setTotalCostSales(totalCost);

            LocalDateTime date = LocalDateTime.now();
            sale.setDate(date);
            saleRepo.save(sale);
            salePositions.clear();
        }
    }

    public Iterable<Sale> findAll() {
        return saleRepo.findAll();
    }

    public Iterable<SalePosition> findAllSalePosition() {
        return salePositionRepo.findAll();
    }

    public Integer getRandomDiscount(Integer from, Integer to) {
        return (new Random()
                .ints(from, to)
                .iterator()
                .nextInt());
    }

    public Iterable<Statistic> getHistory() {
        return staticService.findAll();
    }

    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void setDiscountRandomProduct() {
        if (productRepo.count() != 0 && saleRepo.count() != 0) {
            Iterable<Product> getProduct = productRepo.findAll();

            // Либо сделать файл конфигурации и хранить там Product_id со скидкой,
            // при запуске программы, считывать значение и искать сразу этот Product
            for (Product product : getProduct) {
                if (product.getIdDiscountProduct() != null && product.getIdDiscountProduct() != 0) {
                    productRepo.updateProduct(0.0, 0L, product.getIdDiscountProduct());
                }
            }

            Long getId = productRepo.getRandomProduct();
            setRandomProduct(productRepo.findById(getId).get());
            setDiscount(getRandomDiscount(5, 11));

            getRandomProduct().setDiscountCost(getRandomProduct().getCost() -
                    getRandomProduct().getCost() * getDiscount() / 100);

            Double discount = getRandomProduct().getDiscountCost();

            productRepo.updateProduct(discount, getId, getId);

            LocalDateTime date = LocalDateTime.now();
            staticService.addStatistic(date,
                    getRandomProduct().getName(),
                    getDiscount());
        }
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getDiscount() {
        return discount;
    }

    public Product getRandomProduct() {
        return randomProduct;
    }

    public void setRandomProduct(Product randomProduct) {
        this.randomProduct = randomProduct;
    }

}
