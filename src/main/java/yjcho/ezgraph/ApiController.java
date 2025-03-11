package yjcho.ezgraph;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class ApiController {

    @GetMapping("/front")
    @ResponseBody
    public String index() {
        return "hi";
    }
}
