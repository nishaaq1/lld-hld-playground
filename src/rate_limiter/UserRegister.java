package rate_limiter;

import rate_limiter.dto.RateLimitType;
import rate_limiter.dto.UserRegistrationDto;
import rate_limiter.dto.UserType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserRegister {

    Map<String, UserRegistrationDto> registration = new HashMap<>();

    public void registerUser(String userId, UserType userType, RateLimitType rateLimitType) {
        if (Objects.nonNull(registration.get(userId))) {
            throw new RuntimeException("User already exist");
        }
        if (UserType.NORMAL.equals(userType)
                && RateLimitType.SLIDING_WINDOW.equals(rateLimitType)) {

            UserRegistrationDto user = UserRegistrationDto.builder()
                    .limiterType(RateLimitType.SLIDING_WINDOW)
                    .maxCount(5)
                    .userId(userId)
                    .userType(userType)
                    .millisecond(10000)
                    .build();
            registration.put(userId, user);
            return;
        }

        if (UserType.PREMIUM.equals(userType)
                && RateLimitType.SLIDING_WINDOW.equals(rateLimitType)) {
            UserRegistrationDto user = UserRegistrationDto.builder()
                    .limiterType(RateLimitType.SLIDING_WINDOW)
                    .maxCount(10)
                    .userId(userId)
                    .userType(userType)
                    .millisecond(10000)
                    .build();
            registration.put(userId, user);
            return;
        }

        if (UserType.NORMAL.equals(userType)
                && RateLimitType.FIXED_WINDOW.equals(rateLimitType)) {
            UserRegistrationDto user = UserRegistrationDto.builder()
                    .limiterType(RateLimitType.FIXED_WINDOW)
                    .maxCount(5)
                    .userId(userId)
                    .userType(userType)
//                    .millisecond(10000)
                    .build();
            registration.put(userId, user);
            return;
        }

        if (UserType.PREMIUM.equals(userType)
                && RateLimitType.FIXED_WINDOW.equals(rateLimitType)) {
            UserRegistrationDto user = UserRegistrationDto.builder()
                    .limiterType(RateLimitType.SLIDING_WINDOW)
                    .maxCount(5)
                    .userId(userId)
                    .userType(userType)
//                    .millisecond(10000)
                    .build();
            registration.put(userId, user);
        }

    }
}
