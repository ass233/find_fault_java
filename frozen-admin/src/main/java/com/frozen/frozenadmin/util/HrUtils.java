package com.frozen.frozenadmin.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by sang on 2017/12/30.
 */
public class HrUtils {
    public static UserDetails getCurrentHr() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
