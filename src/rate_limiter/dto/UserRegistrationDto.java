package rate_limiter.dto;

public class UserRegistrationDto {

    private final String userId;
    private final UserType userType;
    private final RateLimitType limiterType;
    private final int maxCount;
    private   int milliseconds;

    // Private constructor so objects can only be made via the Builder
    private UserRegistrationDto(Builder builder) {
        this.userId = builder.userId;
        this.userType = builder.userType;
        this.limiterType = builder.limiterType;
        this.maxCount = builder.maxCount;
        this.milliseconds = builder.milliseconds;
    }

    // Getters
    public String getUserId() { return userId; }
    public UserType getUserType() { return userType; }
    public RateLimitType getLimiterType() { return limiterType; }
    public int getMaxCount() { return maxCount; }
    public int getMilliseconds() { return milliseconds; }

    // Static method to initiate the builder
    public static Builder builder() {
        return new Builder();
    }

    // The Builder Class
    public static class Builder {
        private String userId;
        private UserType userType;
        private RateLimitType limiterType;
        private int maxCount;
        private int milliseconds;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder userType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public Builder limiterType(RateLimitType limiterType) {
            this.limiterType = limiterType;
            return this;
        }

        public Builder maxCount(int maxCount) {
            this.maxCount = maxCount;
            return this;
        }

        public Builder millisecond(int milliseconds) {
            this.milliseconds = milliseconds;
            return this;
        }

        public UserRegistrationDto build() {
            return new UserRegistrationDto( this);
        }
    }
}
