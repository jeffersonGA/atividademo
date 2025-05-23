package com.example.applications;

import com.example.entities.Product;
import com.example.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductApplicationTest {

    @InjectMocks
    private ProductApplication productApplication;

    @Mock
    private ProductService productService;

    private Product product;

    @BeforeEach
    public void setup() {
        product = new Product(1, "Bola", 15.00f, "C:\\imagens\\bola.jpg");
    }

    @Test
    public void testaSalvaImagemCorretamente() {
        Mockito.when(productService.save(product)).thenReturn(true);

        productApplication.append(product);

        Mockito.verify(productService, Mockito.times(1)).save(product);


    }

    @Test
    public void RemoverImagemCorretamenteS() {
        Mockito.doNothing().when(productService).remove(product.getId());

        productApplication.remove(product.getId());

        Mockito.verify(productService, Mockito.times(1)).remove(product.getId());
    }

    @Test
    public void deveAtualizarImagemCorretamente() {
        Mockito.doNothing().when(productService).update(product);

        productApplication.update(product.getId(), product);

        Mockito.verify(productService, Mockito.times(1)).update(product);
    }


}





