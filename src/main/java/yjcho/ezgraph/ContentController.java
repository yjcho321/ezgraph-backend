package yjcho.ezgraph;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yjcho.ezgraph.app.content.ContentService;
import yjcho.ezgraph.system.Result;

@RestController
@AllArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping("/graphs")
    public Result getAllUserGraphs() {
        return new Result(true, HttpStatus.OK.value(), "", "graphs");
    }

    @GetMapping("/templates")
    public Result getTemplates() {
        return new Result(true, HttpStatus.OK.value(), "", "templates");
    }

    @GetMapping("/shared")
    public Result getShared() {
        return new Result(true, HttpStatus.OK.value(), "", "shared");
    }

    @GetMapping("/admin")
    public Result getAdmin() {
        return new Result(true, HttpStatus.OK.value(), null, "admin");
    }

}
