package com.opt.saleuk.controller;

import com.opt.saleuk.service.security.SecurityService;
import com.opt.saleuk.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Arizel on 06.01.2018.
 */
@Controller
@RequestMapping(value = "/auth")
public class AuthorizationController {

    @Autowired
    SecurityService securityService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String doLogin(HttpServletRequest request){
        ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        //securityService.autoLogin()
//
//        String email = form.getLogin();
//
//        if (StringUtils.isNotEmpty(email)) {
//            User user = userService.getUserByEmail(form.getLogin());
//            if (null != user) {
//                if (!user.getEnabled()){
//                    return response;
//                }
//            } else {
//                return response;
//            }
//        } else {
//            return response;
//        }
       // boolean result = securityService.autoLogin(form.getLogin(), form.getPassword());
//        if (!result){
//            return response;
//        } else {
//            User user = userService.getSingleUserById(securityService.getAuthenticatedUserId(form.getLogin()));
//            user.setPassword(null);
//            request.getSession().setAttribute("USER", user);
//            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
//        }
        return "redirect:/hello";
    }

//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/isauthorized", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
//    public AuthFlagDTO isAuthorized(HttpServletRequest request){
//        User thisUser = (User) request.getSession().getAttribute("USER");
//        AuthFlagDTO result;
//        if (null==thisUser){
//            result = new AuthFlagDTO("NA");
//        } else {
//            result = new AuthFlagDTO(thisUser.getRole().getRoleName());
//        }
//        return result;
//    }
//
//
//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
//    public ResponseEntity<Boolean> doLogout(HttpServletRequest request) throws ServletException {
//        User user = (User) request.getSession().getAttribute("USER");
//        if (user != null) {
//            request.logout();
//            request.getSession().invalidate();
//        } else {
//            return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
//    }

}
