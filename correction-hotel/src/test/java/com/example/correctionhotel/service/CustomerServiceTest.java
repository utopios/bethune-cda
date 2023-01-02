package com.example.correctionhotel.service;

import com.example.correctionhotel.entity.Customer;
import com.example.correctionhotel.repository.CustomerRepository;
import com.example.correctionhotel.util.exceptions.ErrorFieldException;
import com.example.correctionhotel.util.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    private CustomerService customerService;

    private Customer customer;
    @Mock
    private CustomerRepository customerRepository;
    @BeforeEach
    void setUp() throws Exception {
        //Arrange
        customerService = new CustomerService(customerRepository);
        customer = new Customer();
        //lenient().doNothing().when(customerRepository).create(customer);
    }

    private static Stream<Arguments> getValuesOfTest() {
        return Stream.of(
                arguments("", "", ""),
                arguments("", "ff", "ff"),
                arguments("rr", "", "rr"),
                arguments("rr", "rr", "")
                );
    }

    //Test 1, un des champs est vide => lever une exception
    @ParameterizedTest
    /*@ValueSource(strings = {"", " ","\t"})*/
    @MethodSource("getValuesOfTest")
    void createShouldRaiseExceptionWhenEmptyFields(String firstName, String lastName, String phone) {
        //Act with Assert
        Assertions.assertThrowsExactly(ErrorFieldException.class, () -> {
            customerService.create(firstName,lastName, phone);
        });
    }
    //Test 2, creation fonctionne avec un boolean
    @Test
    void createShouldReturnTrueIfCorrectValue() throws Exception {
        //Arrange
        /* A ne pas faire
        customer.setFirstName("toto");
        customer.setLastName("tata");
        customer.setPhone("0101010101");
        */
        //Act
        boolean result = customerService.create("toto", "tata", "0101010101");

        //Assert
        Assertions.assertTrue(result);
    }


    //Test 3, erreur si exception avec repository
    @Test
    void createShouldReturnFalseIfExceptionRespository() throws Exception {
        //Arrange
        lenient().doThrow(new Exception()).when(customerRepository).create(customer);

        //Act
        boolean result = customerService.create("toto", "tata", "0101010101");

        //Assert
        Assertions.assertFalse(result);
    }

    @Test
    void getCustomerShouldReturnCustomerIfCorrectId() throws Exception {
        //Arrange
        customer.setId(1);
        Mockito.when(customerRepository.findById(1, Customer.class)).thenReturn(customer);

        //Act
        Customer result = customerService.getCustomerById(1);

        //Assert
        Assertions.assertEquals(1, result.getId());
    }

    @Test
    void getCustomerShouldRaiseExceptionIWrongId() throws Exception {
        //Arrange
        customer.setId(1);
        Mockito.when(customerRepository.findById(1, Customer.class)).thenReturn(null);

        Assertions.assertThrowsExactly(NotFoundException.class, () -> {
           customerService.getCustomerById(1);
        });
    }
}
