```java
package model;

import java.time.LocalDate;

public class BusPass {

    private Long id;
    private Passenger passenger;
    private String route;
    private PassType passType;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private PassStatus status;

    public BusPass(Long id, Passenger passenger, String route,
                   PassType passType, LocalDate issueDate,
                   LocalDate expiryDate, PassStatus status) {

        this.id = id;
        this.passenger = passenger;
        this.route = route;
        this.passType = passType;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    public Long getId() { return id; }
    public Passenger getPassenger() { return passenger; }
    public String getRoute() { return route; }
    public PassType getPassType() { return passType; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public PassStatus getStatus() { return status; }

    public void setStatus(PassStatus status) {
        this.status = status;
    }

    public void renew(int days) {
        this.issueDate = LocalDate.now();
        this.expiryDate = LocalDate.now().plusDays(days);
        this.status = PassStatus.ACTIVE;
    }
}
```
