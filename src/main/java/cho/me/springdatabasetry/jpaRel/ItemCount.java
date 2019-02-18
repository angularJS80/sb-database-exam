package cho.me.springdatabasetry.jpaRel;

public class ItemCount {
    int id;
    Long count;

    public ItemCount(int id,Long count){
        this.id = id;
        this.count = count;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ItemCount{" +
                "id=" + id +
                ", count=" + count +
                '}';
    }
}
