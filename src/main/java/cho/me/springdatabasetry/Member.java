package cho.me.springdatabasetry;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Member {
    @Id @GeneratedValue
    private int seq;

    private String name;

    public Collection<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Collection<Phone> phones) {
        this.phones = phones;
    }

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "memberId")
    private Collection<Phone> phones;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addPhone(Phone phone) {
        if(phones == null){
            phones = new ArrayList<Phone>();
        }
        phones.add(phone);
    }
}
