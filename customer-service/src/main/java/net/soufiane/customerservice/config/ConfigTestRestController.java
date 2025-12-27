package net.soufiane.customerservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/config-test")
@RefreshScope
public class ConfigTestRestController {

    @Value("${global.params.p1}")
    private String a;
    @Value("${global.params.p2}")
    private String b;

    @Autowired
    private CustomerConfigParams customerConfigParams;

    @GetMapping("/testconfig1")
    public Map<String, String> getGlobalParams() {
        return Map.of("param1", a, "param2", b);
    }

    @GetMapping("/testconfig2")
    public CustomerConfigParams getGlobalParams2() {
        return customerConfigParams;
    }
}
