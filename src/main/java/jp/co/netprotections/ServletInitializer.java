/**
 * 
 */
package jp.co.netprotections;

/**
 * @author v.lai
 *
 */
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
 
public class ServletInitializer extends SpringBootServletInitializer {
 
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BootCampStartupApplication.class);
    }
 
}
