package yjcho.ezgraph.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Result {
    private boolean flag;
    private Integer code;
    private String message;
    private Object data;
}
