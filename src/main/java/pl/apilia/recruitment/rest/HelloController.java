package pl.apilia.recruitment.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {


  @GetMapping(produces = "application/json")
  public ResponseEntity<String> hello() {
    return ResponseEntity.ok("Hello Spring");
  }

  @GetMapping(value = "/{name}", produces = "application/json")
  public ResponseEntity<String> helloUser(@PathVariable("name") String name) {
    return ResponseEntity.ok("Hello, " + name);
  }
}
