package xyz.codingmentor.andris.webshop.bean;

import xyz.codingmentor.andris.webshop.enums.Sex;
import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import xyz.codingmentor.andris.webshop.annotation.Validate;
import xyz.codingmentor.andris.webshop.constraint.Name;
import xyz.codingmentor.andris.webshop.constraint.BirthDate;

/**
 *
 * @author brianelete
 */
@Name
@BirthDate
@Validate
public class UserEntity {

    @NotNull
    @Size(min = 6)
    private String username;
    @NotNull
    @Size(min = 6)
    @Pattern.List({
        @Pattern(regexp = ".*[a-z].*"),
        @Pattern(regexp = ".*[A-Z].*"),
        @Pattern(regexp = ".*[0-9].*"),
        @Pattern(regexp = ".*[=+<>.,].*")
    })
    private String password;
    private String firstname;
    private String lastname;
    @NotNull
    @Pattern(regexp = "^\\d{4}.*")
    private String address;
    @NotNull
    @Pattern(regexp = "^(06|\\+36)\\d{9}")
    private String phone;
    @NotNull
    @Email
    private String email;

    private Sex sex;
    @NotNull
    @Past
    private Date registrationDate;
    @NotNull
    @Past
    private Date lastModifiedDate;
    private Date dateOfBirth;
    private boolean admin;

    public UserEntity() {
        //empty
    }

    private UserEntity(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
        this.registrationDate = builder.registrationDate;
        this.lastModifiedDate = builder.lastModifiedDate;
        this.dateOfBirth = builder.dateOfBirth;
        this.admin = builder.admin;
        this.sex = builder.sex;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getfirstname() {
        return firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isAdmin() {
        return admin;
    }

    public Sex getSex() {
        return sex;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    @Override
    public String toString() {
        return "UserEntity{" + "username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", phone=" + phone + ", email=" + email + ", sex=" + sex + ", registrationDate=" + registrationDate + ", lastModifiedDate=" + lastModifiedDate + ", dateOfBirth=" + dateOfBirth + ", admin=" + admin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserEntity other = (UserEntity) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    

    public static class Builder {

        private String username;
        private String password;
        private String firstname;
        private String lastname;
        private String address;
        private String phone;
        private String email;
        private Sex sex;
        private Date registrationDate;
        private Date lastModifiedDate;
        private Date dateOfBirth;
        private boolean admin;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder sex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public Builder registrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder lastModifiedDate(Date lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder admin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }
}
