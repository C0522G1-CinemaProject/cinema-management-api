package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.customer.CustomerDto;
import projectbackend.model.customer.Customer;
import projectbackend.repository.customer.ICustomerRepository;
import projectbackend.repository.customer.ICustomerTypeRepository;
import projectbackend.service.customer.ICustomerService;
import projectbackend.service.customer.ICustomerTypeService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "addressSearch", defaultValue = "") String addressSearch,
                           @RequestParam(value = "phoneSearch", defaultValue = "") String phoneSearch,
                           Model model) {
        List<Customer> customerList = iCustomerService.findAll();

        model.addAttribute("customerList", iCustomerService.searchCustomer(nameSearch, addressSearch,
                phoneSearch, pageable));
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("addressSearch", addressSearch);
        model.addAttribute("phoneSearch", phoneSearch);

        return "customer/list";
    }

//    @GetMapping("/edit/{id}")
//    public String editCus(@PathVariable Integer id, Model model) {
//        Customer customer = iCustomerService.findById(id).get();
//
//        if (customer.getDayOfBirth().contains("/")) {
//            String[] arr = customer.getDayOfBirth().split("/");
//            customer.setDayOfBirth(arr[2] + "-" + arr[1] + "-" + arr[0]);
//        }
//
//        CustomerDto customerDto = new CustomerDto();
//        BeanUtils.copyProperties(customer, customerDto);
//
//        model.addAttribute("customerDto", customerDto);
//        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
//
//        LocalDate minAge = LocalDate.now().minusYears(80);
//        LocalDate maxAge = LocalDate.now().minusYears(18);
//        model.addAttribute("minAge", minAge);
//        model.addAttribute("maxAge", maxAge);
//
//        return "customer/edit";
//    }
}