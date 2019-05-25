package com.elibrarysecurity.projectsecurity.repository;

        import com.elibrarysecurity.projectsecurity.model.UserType;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<UserType,Long> {
   // Role findByRole(String role);
}
