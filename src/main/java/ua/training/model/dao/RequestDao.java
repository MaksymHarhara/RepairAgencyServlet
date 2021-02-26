package ua.training.model.dao;

import ua.training.model.entity.Request;
import ua.training.model.entity.User;

import java.awt.print.Pageable;
import java.util.List;

public interface RequestDao extends GenericDao<Request>{

    List<Request> findByCreatorAndStatus(String creator, String status);

    List<Request> findByCreatorAndNotStatus(String creator, String status, int page, int size);

    List<Request> findByMasterAndStatus(String master, String status,int page,int size);

    List<Request> findByStatus( String status, int page,int size);

    List<Request> findByKeyword(String keyword, int page, int size);

    void updateStatusAndPriceAndUser(Long id, String status, Long price, User user);

    void updateStatusAndReason(Long id, String status, String reason);
}
