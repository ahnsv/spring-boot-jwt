package anq10;

import java.util.ArrayList;
import java.util.Arrays;

import anq10.model.Board;
import anq10.repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import anq10.model.Role;
import anq10.model.User;
import anq10.service.UserService;

@SpringBootApplication
public class JwtAuthServiceApp implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    BoardRepository boardRepository;

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthServiceApp.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... params) throws Exception {
        User admin = User.builder()
                .username("admin")
                .password("admin")
                .email("admin@email.com")
                .roles(new ArrayList<>(Arrays.asList(Role.ROLE_ADMIN))).build();
        userService.signup(admin);

        User client = User.builder()
                .username("client")
                .password("client")
                .email("client@email.com")
                .roles(new ArrayList<>(Arrays.asList(Role.ROLE_CLIENT))).build();
        userService.signup(client);


        Board mainBoard = Board.builder()
                .name("main")
                .categories(new ArrayList<String>(Arrays.asList("hello", "hello2", "helloworld")))
                .build();
        boardRepository.save(mainBoard);
    }

}
