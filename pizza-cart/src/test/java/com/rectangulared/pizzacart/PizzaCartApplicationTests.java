package com.rectangulared.pizzacart;

import com.rectangulared.common.entity.*;
import com.rectangulared.common.repository.OrderRepository;
import com.rectangulared.common.repository.PizzaRepository;
import com.rectangulared.pizzacart.service.PizzaCartService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static reactor.core.publisher.Mono.when;

@RunWith(MockitoJUnitRunner.class)
public class PizzaCartApplicationTests {

    private PizzaRepository pizzaRepository = mock(PizzaRepository.class);
    private OrderRepository orderRepository = mock(OrderRepository.class);
    private PizzaCartService pizzaCartService;
    List<Integer> testPizzasIds = Arrays.asList(1, 2, 3);
    Integer[] testIngredientsId = {1, 2, 3};
    List<Ingredient> ingredients = Arrays.asList(new Ingredient("Test1", IngredientType.CHEESE, 12.3),
            new Ingredient("Test1", IngredientType.CHEESE, 12.3),
            new Ingredient("Test1", IngredientType.CHEESE, 12.3));
    List<Pizza> pizzas = Arrays.asList(new Pizza(new PizzaDTO("TestPizza1", testIngredientsId, PizzasForm.CIRCLE, true, true), ingredients),
            new Pizza(new PizzaDTO("TestPizza2", testIngredientsId, PizzasForm.CIRCLE, true, true), ingredients),
            new Pizza(new PizzaDTO("TestPizza3", testIngredientsId, PizzasForm.CIRCLE, true, true), ingredients));

    @BeforeTestClass
    public static void globalSetUp() {
        System.out.println("Initial setup...");
    }

    @Before
    public void setUp() {
        System.out.println("Creating mocks");
        PizzaRepository pizzaRepository = mock(PizzaRepository.class);
        OrderRepository orderRepository = mock(OrderRepository.class);
        System.out.println("Initializing all test values");
        List<Integer> testPizzasIds = Arrays.asList(1, 2, 3);
        Integer[] testIngredientsId = {1, 2, 3};
        List<Ingredient> ingredients = Arrays.asList(new Ingredient("Test1", IngredientType.CHEESE, 12.3),
                new Ingredient("Test1", IngredientType.CHEESE, 12.3),
                new Ingredient("Test1", IngredientType.CHEESE, 12.3));
        List<Pizza> pizzas = Arrays.asList(new Pizza(new PizzaDTO("TestPizza1", testIngredientsId, PizzasForm.CIRCLE, true, true), ingredients),
                new Pizza(new PizzaDTO("TestPizza2", testIngredientsId, PizzasForm.CIRCLE, true, true), ingredients),
                new Pizza(new PizzaDTO("TestPizza3", testIngredientsId, PizzasForm.CIRCLE, true, true), ingredients));
        System.out.println("BEFORE setup complete");
    }

    @Test
    public void testSetPrice() {
        System.out.println("Beginning testSetPrice");
        Mockito.when(pizzaRepository.findAllByIdIn(testPizzasIds)).thenReturn(pizzas);
        System.out.println("Creating service with mocks");
        PizzaCartService pizzaCartService = new PizzaCartService(pizzaRepository, orderRepository);
        pizzaCartService.getPizzaFromOrder(testPizzasIds);
        Assert.assertEquals(pizzas.get(0).getPrice(), 27.675, 0.0005);
        Mockito.verify(pizzaRepository).findAllByIdIn(testPizzasIds);
        System.out.println("testSetPrice has finished");
    }

}
