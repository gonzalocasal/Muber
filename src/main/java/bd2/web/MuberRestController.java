package bd2.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class MuberRestController {

	@RequestMapping(value = "/example", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String pasajeros() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
}
