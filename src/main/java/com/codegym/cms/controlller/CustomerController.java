package com.codegym.cms.controlller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
   @GetMapping("/customers")
    public ModelAndView showListCustomer(){
       return new ModelAndView("list","customers",customerService.findAll());
   }
   @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
       return new ModelAndView("create","customer",new Customer());
   }
   @PostMapping("/create-customer")
    public String CreateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirect){
       customerService.save(customer);
       redirect.addFlashAttribute("message","list.message.create");
       return "redirect:/customers";
   }
   @GetMapping("/delete-customer/{id}")
    public String deleteCustomer (@PathVariable int id,RedirectAttributes redirect){
       customerService.remove(id);
       redirect.addFlashAttribute("message","list.message.delete");
       return "redirect:/customers";
   }
   @GetMapping("edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
       return new ModelAndView("edit","customer",customerService.findById(id));
   }
   @PostMapping("edit-customer")
    public String editCustomer(@ModelAttribute Customer customer,RedirectAttributes redirect){
       customerService.save(customer);
       redirect.addFlashAttribute("message","list.message.edit");
       return "redirect:/customers";
   }
}
