package ua.training.model.dao.mapper;

import ua.training.model.entity.Request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class RequestMapper {
    public Request extractFromResultSet(ResultSet rs)
            throws SQLException {
        return Request.builder()
                .id(rs.getLong("id"))
                .request(rs.getString("request"))
                .status(rs.getString("status"))
                .price(rs.getLong("price"))
                .reason(rs.getString("reason"))
                .creator(rs.getString("creator"))
                .date(LocalDate.now(Clock.system(ZoneId.of("Europe/Kiev"))))//todo переробити
                .build();
    }
}
