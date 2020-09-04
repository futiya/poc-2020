package com.example.demo.controller;

import com.example.demo.model.RspModel;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2020-09-03 17:36
 */
@RestController
@RequestMapping( "/api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<RspModel> listAll(){
        try {
            List<User> users = userService.listAll();
            if(users!=null){
                RspModel rspModel = new RspModel();
                rspModel.setCode(200);
                rspModel.setMsg("OK");
                rspModel.setUsers(users);
                return new ResponseEntity(rspModel, HttpStatus.OK);
            }else{
                RspModel rspModel = new RspModel();
                rspModel.setCode(404);
                rspModel.setMsg("No Records");
                return new ResponseEntity(rspModel, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            RspModel rspModel = new RspModel();
            rspModel.setCode(500);
            rspModel.setMsg(e.getMessage());
            return new ResponseEntity(rspModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping( "/users/{id}")
    @ResponseBody
    public ResponseEntity<RspModel> getUser(@PathVariable("id") int id){
        try {
            User user = userService.findUser(id);
            if(user!=null){
                RspModel rspModel = new RspModel();
                rspModel.setCode(200);
                rspModel.setMsg("OK");
                rspModel.setUsers(user);
                return new ResponseEntity(rspModel, HttpStatus.OK);
            }else{
                RspModel rspModel = new RspModel();
                rspModel.setCode(404);
                rspModel.setMsg("ACCOUNT NOT FOUND");
                return new ResponseEntity(rspModel, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            RspModel rspModel = new RspModel();
            rspModel.setCode(500);
            rspModel.setMsg(e.getMessage());
            return new ResponseEntity(rspModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    @ResponseBody
    public ResponseEntity<RspModel> addUser(@RequestBody User user){
        try {
            user.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
            user.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            System.out.println(Date.valueOf(LocalDate.now()).toString());
            userService.addUser(user);

            RspModel rspModel = new RspModel();
            rspModel.setCode(201);
            rspModel.setMsg("Account "+user.getEmail()+" is created");
            return new ResponseEntity<>(rspModel,HttpStatus.CREATED);
        }catch (Exception e){
            RspModel rspModel = new RspModel();
            rspModel.setCode(500);
            rspModel.setMsg(e.getMessage());
            return new ResponseEntity(rspModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity<RspModel> addUser(@PathVariable("id") int id,@RequestBody User user){
        try {
            User exsitedUser = userService.findUser(id);
            if(exsitedUser!=null){
                if (user.getEmail()==null)
                    user.setEmail(exsitedUser.getEmail());
                if (user.getName()==null)
                    user.setName(exsitedUser.getName());
                if (user.getManagerId()!=0)
                    user.setManagerId(exsitedUser.getManagerId());
                user.setCreatedAt(exsitedUser.getCreatedAt());
                user.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
                userService.updateUser(id,user);

                RspModel rspModel = new RspModel();
                rspModel.setCode(200);
                rspModel.setMsg("User "+id+" is updated");
                return new ResponseEntity<>(rspModel,HttpStatus.OK);
            }else {
                RspModel rspModel = new RspModel();
                rspModel.setCode(404);
                rspModel.setMsg("User "+id+" Not Found");
                return new ResponseEntity<>(rspModel,HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            RspModel rspModel = new RspModel();
            rspModel.setCode(500);
            rspModel.setMsg(e.getMessage());
            return new ResponseEntity(rspModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<RspModel> deleteByUserId(@PathVariable("id") int id){
        try {
            User exsitedUser = userService.findUser(id);
            if(exsitedUser!=null){

                userService.deleteUser(id);

                RspModel rspModel = new RspModel();
                rspModel.setCode(200);
                rspModel.setMsg("User "+id+" is deleted");
                return new ResponseEntity<>(rspModel,HttpStatus.OK);
            }else {
                RspModel rspModel = new RspModel();
                rspModel.setCode(404);
                rspModel.setMsg("User "+id+" Not Found");
                return new ResponseEntity<>(rspModel,HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            RspModel rspModel = new RspModel();
            rspModel.setCode(500);
            rspModel.setMsg(e.getMessage());
            return new ResponseEntity(rspModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
