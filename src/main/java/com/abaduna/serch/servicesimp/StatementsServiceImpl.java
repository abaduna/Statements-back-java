package com.abaduna.serch.servicesimp;



import com.abaduna.serch.models.StatementRequest;
import com.abaduna.serch.models.Statements;
import com.abaduna.serch.models.User;
import com.abaduna.serch.repository.StatementsRepository;
import com.abaduna.serch.repository.UserRepository;
import com.abaduna.serch.services.StatementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatementsServiceImpl implements StatementsService {

    @Autowired
    private StatementsRepository statementsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Statements> getAllStatements() {
        return statementsRepository.findAll();
    }

    @Override
    public Optional<Statements> getStatementById(Long id) {
        return statementsRepository.findById(id);
    }

    @Override
    public Statements createStatement(StatementRequest request) {
        Statements s = new Statements();
        s.setTitulo(request.getTitulo());
        s.setContenidoLargo(request.getContenidoLargo());

        if (request.getUserId() != null) {
            userRepository.findById(request.getUserId())
                    .ifPresent(s::setUser);
        } else if (request.getUserNane() != null) {
            User newUser = new User();
            newUser.setName(request.getUserNane());

            userRepository.save(newUser);
            s.setUser(newUser);
        }
        System.out.println("UserId: " + request.getUserId());
        System.out.println("UserName: " + request.getUserNane());




        return statementsRepository.save(s);
    }
    public List<Statements> getStatementsByUserName(String name) {
        return statementsRepository.findByUser_NameContainingIgnoreCase(name);
    }

    @Override
    public boolean deleteStatement(Long id) {
        if (statementsRepository.existsById(id)) {
            statementsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
