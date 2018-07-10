package pl.js.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.js.entity.Role;
import pl.js.repository.RoleRepository;

public class RoleConverter implements Converter<String, Role> {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role convert(String source) {
		Role role = roleRepository.findByRole(source);
		return role;
	}
}
