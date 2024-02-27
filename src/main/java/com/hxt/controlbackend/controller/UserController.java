package com.hxt.controlbackend.controller;

import com.hxt.controlbackend.pojo.JwtToken;
import com.hxt.controlbackend.pojo.LoginParma;
import com.hxt.controlbackend.pojo.PermissionRouter;
import com.hxt.controlbackend.pojo.R;
import com.hxt.controlbackend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public R<JwtToken> login(@RequestBody LoginParma loginParma) {
        JwtToken jwtToken = userService.login(loginParma);
        return new R<>(jwtToken);
    }

    @PostMapping("/refreshToken")
    public R<JwtToken> refreshToken(@RequestBody String refreshToken) {
        JwtToken jwtToken = userService.refreshToken(refreshToken);
        return new R<>(jwtToken);
    }

    @GetMapping("/getAsyncRoutes")
    public String getAsyncRoutes() {
        PermissionRouter permissionRouter = new PermissionRouter();
        permissionRouter.setPath("/permission");
        PermissionRouter.Mata mata = new PermissionRouter.Mata();
        mata.setTitle("权限管理");
        mata.setIcon("lollipop");
        mata.setRank(10);
        permissionRouter.setMata(mata);
        PermissionRouter child = new PermissionRouter();
        child.setPath("/permission/page/index");
        child.setName("PermissionPage");
        PermissionRouter.Mata cmata = new PermissionRouter.Mata();
        cmata.setTitle("menus.permissionPage");
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("common");
        cmata.setRoles(roles);
        child.setMata(cmata);

        PermissionRouter child1 = new PermissionRouter();
        child1.setPath("/permission/button/index");
        child1.setName("PermissionButton");
        PermissionRouter.Mata cmata1 = new PermissionRouter.Mata();
        cmata1.setTitle("menus.permissionButton");
        cmata1.setRoles(roles);
        List<String> auths = new ArrayList<>();
        auths.add("btn_add");
        auths.add("btn_edit");
        auths.add("btn_delete");
        cmata1.setAuths(auths);
        child1.setMata(cmata1);
        List<PermissionRouter> children = new ArrayList<>();
        children.add(child);
        children.add(child1);
        permissionRouter.setChildren(children);
        List<PermissionRouter> permissionRouters = new ArrayList<>();
        permissionRouters.add(permissionRouter);
        String router = "{\n" +
                "    \"code\": 200,\n" +
                "    \"data\": [\n" +
                "    ]\n" +
                "}";
//        return new R<>(permissionRouters);
        return router;
    }
}
