package com.test.studentapp;

import java.awt.EventQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
//@EnableJpaRepositories("repositories")
@SpringBootApplication 
@EnableAutoConfiguration
@ComponentScan({"com.test.studentapp.*"})
public class Application  implements CommandLineRunner  { //extends SpringBootServletInitializer
		
    private static Logger LOG = (Logger) LoggerFactory
      .getLogger(Application.class);

    public static void main(String[] args) {
    	LOG.info("STARTING THE APPLICATION");
        //SpringApplication.run(Application.class, args);
        new SpringApplicationBuilder(Application.class).headless(false).run(args);
        LOG.info("APPLICATION FINISHED");
    }
 
    @Override
    public void run(String... args) {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentsGUI window = new StudentsGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
				
		
    	
		
		/*
		 * JFrame frame = new JFrame("Spring Boot Swing App");
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setSize(300,300);
		 * JPanel panel = new JPanel(new BorderLayout()); JTextField text = new
		 * JTextField("Spring Boot can be used with Swing apps"); panel.add(text,
		 * BorderLayout.CENTER); frame.setContentPane(panel); frame.setVisible(true);
		 */
		 
    	
//        LOG.info("EXECUTING : command line runner");
// 
//        for (int i = 0; i < args.length; ++i) {
//            LOG.info("args[{}]: {}", i, args[i]);
//        }
    }
}
