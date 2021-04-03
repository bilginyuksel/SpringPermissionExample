package com.rollbot.example.permission;

import com.rollbot.example.permission.config.RollbotConfigProps;
import com.rollbot.example.permission.service.UserService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Properties;

@RestController
@RequestMapping(path = "/api")
public class PermissionController {
    private final UserService userService;

    public PermissionController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/greetings/{name}")
    public String helloWorld(@PathVariable(name = "name") String username,
                             @RequestParam(required = false) String key,
                             @RequestParam(required = false) String lol) {
        return "key= " + key + "\n" +
                "lol= " + lol + "\n" +
                "username= " + username + "\n";
    }

    @GetMapping("/greetings")
    public String getUsername() {
        return userService.getUsername();
    }

    @Setter
    @Getter
    @ToString
    private static class SpecialObject extends BaseResponseDTO {
        private String completeName;
        public SpecialObject(String returnCode, String returnDesc) {
            super(returnCode, returnDesc);
        }
    }

    @PostMapping(value = "/greetings", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SpecialObject postSpecialObject(@RequestBody @Valid SpecialQuery query) {
        System.out.println(query);
        SpecialObject object = new SpecialObject("0", "Success.");
        object.setCompleteName(query.getFirstname() + " " + query.getLastname());
        return object;
    }

}
