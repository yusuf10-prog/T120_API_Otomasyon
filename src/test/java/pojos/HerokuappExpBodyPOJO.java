package pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HerokuappExpBodyPOJO {

    private int bookingid;
    private BookingPOJO booking;
}
