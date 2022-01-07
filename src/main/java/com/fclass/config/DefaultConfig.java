package com.fclass.config;

import com.fclass.TomcatLaucher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
Think of this as the configuration class that Spring boot would have internally
 */
@Configuration
public class DefaultConfig {

        @Bean
        public TomcatLaucher getTomcatLauncher(){
            return new TomcatLaucher();
        }
}
