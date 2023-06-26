package uk.gov.justice.laa.crime.microservice.sqstester.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findOneByUsername(String username);
}
