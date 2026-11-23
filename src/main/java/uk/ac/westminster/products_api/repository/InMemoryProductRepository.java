package uk.ac.westminster.products_api.repository;
import uk.ac.westminster.products_api.DigitalProduct;
import uk.ac.westminster.products_api.PhysicalProduct;
import uk.ac.westminster.products_api.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProductRepository implements ProductRepository
{
    private final Map<Long, Product> store = new HashMap<>();
    private Long nextId = 1L;

    public InMemoryProductRepository() {
// constructor
        save(new DigitalProduct(null, "E-book", 9.99, "/dl/1", 4.2));
        save(new PhysicalProduct(null, "Monitor", 249.99, 5.4, "60x40"));
    }
        @Override
        public Product save (Product product){
            // TODO (a): if the product has no id, give it nextId and increment
            if (product.getId() == null) {
                product.setId(nextId++);
            }
            // TODO (b): put it in he map under its id

            store.put(product.getId(), product);

            // TODO (c): return the product
            return product;
            }
            @Override
            public List<Product> findAll() {
            // TODO: return a copy of store.values()
                return new ArrayList<>(store.values());
        }
        @Override
        public Optional<Product> findById (Long id){
            // TODO: one line, using Optional.ofNullable
            return Optional.ofNullable(store.get(id));
        }
        @Override
        public void delete (Long id){
            // TODO: one line
        }

    }

