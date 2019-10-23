package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    SongRepository songRepository;

    @RequestMapping("/")
    public String homepage(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "homepage";
//admin or user can enter credentials
    }
    //    When new user link is chosen
    @GetMapping("/addUser")
    public String userForm(Model model){

        model.addAttribute("user", new User());
        return "createuser";
    }
    @PostMapping("/process")
    public String processUserForm(@Valid User user,
                                  BindingResult result){
        if (result.hasErrors()){
            return "createuser";
        }
        userRepository.save(user);
        return "redirect:/transaction";
    }

    //    When Yes in create user or admin link on homepage is chosen
//    -make changes on the album repository and display top 3 albums
    @RequestMapping("/admin")
    public String adminForm(Model model){
        model.addAttribute("album", new Album()); //add new album
        return "albumlibrary";
    }
    @PostMapping("/processadmin")
    public String processAdminForm(@Valid Album album,
                                   BindingResult result){
        if (result.hasErrors()){
            return "admin";
        }
        albumRepository.save(album);
        return "albumlibrary";
    }
    // Delete albums
    @RequestMapping("/delete/{id}")
    public String delAlbum(@PathVariable("id") long id){
        albumRepository.deleteById(id);
        return "redirect:/albumlibrary";
    }
    // Need to do calculation for the top 3 albums not show here yet
    @RequestMapping("/detail")
    public String showTop(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("album",albumRepository.findAll());
        return "showTop";
    }
    // Current user logs in -- password before transaction page
    @RequestMapping("/validateuser/{id}") // id for the user in user repository
    public String uservalidation(@PathVariable("id") long id,
                                 @Valid User password, Model model,
                                 BindingResult result){
        if (result.hasErrors()){
            return "validateuser";
        }
        User inputpassword = userRepository.findById(id); // id for the user in user repository
        if (inputpassword.getPassword().equalsIgnoreCase(password.getPassword())){
            // If password matches
            return "transaction"; //start doing transactions after valid password and username
        }
        else {
            return "redirect:/"; // Sign in again to type in password again
        }
        @RequestMapping("/transaction")
        public String processDeposit(@PathVariable("id") long id,
        @Valid User user, BindingResult result){
            if (result.hasErrors()) {
                return "deposit";
            } // Not sure how to do the calculation for adding deposit amt
            double balance = transaction.getBalance();
            double deposit = transaction.getDeposit();
            if (transaction.isDeposit())
                balance += deposit;
            else
                return balance;
            transaction.setBalance(balance);
            transaction.save(balance);

            return "albumlibrary";
        }
        @RequestMapping("albumlibrary")
        public String allAlbums(@PathVariable("id") long id, Model model){
            Album album = albumRepository.findAll();
            Set<>
        }

    }
}