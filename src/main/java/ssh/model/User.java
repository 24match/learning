package ssh.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author
 * @Date
 */
@Data
@Entity
@Table(name = "USER_INFO")
public class User implements Serializable {

    private static final long serialVersionUID = 3258160378138074345L;
    private String id;
    private String name;
    private String pwd;
    private Date createDate;
    private Date modifyDate;

    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 36)
    public String getId() {
        return id;
    }

    @Column(name = "NAME", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    @Column(name = "PWD", nullable = false, length = 32)
    public String getPwd() {
        return pwd;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", length = 7)
    public Date getCreateDate() {
        return createDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_DATE", length = 7)
    public Date getModifyDate() {
        return modifyDate;
    }
}
