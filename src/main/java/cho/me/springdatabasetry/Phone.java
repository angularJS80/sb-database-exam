package cho.me.springdatabasetry;

import javax.persistence.*;

@Entity
public class Phone {
    @Id @GeneratedValue
    private int seq;
    private int memberId;
    private String no;

    public Phone(String no) {
        this.no = no;
    }


    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
