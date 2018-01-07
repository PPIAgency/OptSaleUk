package com.opt.saleuk.controller;

import com.opt.saleuk.service.authorization.AuthorizationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Arizel on 06.01.2018.
 */
@Controller
@RequestMapping(value = "/auth")
public class AuthorizationController {

    private static final Logger LOG = Logger.getLogger(AuthorizationController.class);

    @Autowired
    AuthorizationService authorizationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody String doLogin(@RequestParam(name = "username") String login, @RequestParam(name = "password") String password){

        return authorizationService.authorize(login, password) ? "success" : "not success";
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

    //@ResponseStatus()

}
