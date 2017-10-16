package com.ingenico.payment.challange.model.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{


	private static final long serialVersionUID = -601165728325862265L;
	
	private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
