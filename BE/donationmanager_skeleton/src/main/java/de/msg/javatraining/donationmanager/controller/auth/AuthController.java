package de.msg.javatraining.donationmanager.controller.auth;


import de.msg.javatraining.donationmanager.config.security.JwtUtils;
import de.msg.javatraining.donationmanager.persistence.model.User;
import de.msg.javatraining.donationmanager.persistence.repository.RoleRepository;
import de.msg.javatraining.donationmanager.persistence.repository.UserRepository;
import de.msg.javatraining.donationmanager.service.UserDetailsImpl;
import de.msg.javatraining.donationmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  UserService userService;


//  @PostMapping("/login")
//  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
//
//    Authentication authentication = authenticationManager
//        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//    SecurityContextHolder.getContext().setAuthentication(authentication);
//
//    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//
//    String jwt = jwtUtils.generateJwtToken(userDetails);
//
//    List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
//        .collect(Collectors.toList());
//
//
//    return ResponseEntity.ok(new SignInResponse(jwt, userDetails.getId(),
//        userDetails.getUsername(), userDetails.getEmail(), roles));
//  }

//  @PostMapping("/login")
//  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
//    Authentication authentication = authenticationManager
//            .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//    SecurityContextHolder.getContext().setAuthentication(authentication);
//
//    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//
//    // Check if logincount is -1
//    if (userDetails.getLoginCount() == -1) {
//      // Redirect logic here, for example, return a custom response
//      return ResponseEntity.badRequest().body("Password change required");
//    }
//
//    String jwt = jwtUtils.generateJwtToken(userDetails);
//
//    List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
//            .collect(Collectors.toList());
//
//    return ResponseEntity.ok(new SignInResponse(jwt, userDetails.getId(),
//            userDetails.getUsername(), userDetails.getEmail(), userDetails.getLoginCount(), roles));
//  }

  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
    Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    if (userDetails.getLoginCount() == -1) {
      return ResponseEntity.status(HttpStatus.OK)
              .body("{\"message\": \"Password change required\", \"loginCount\": -1}");
    }

    String jwt = jwtUtils.generateJwtToken(userDetails);

    List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
            .collect(Collectors.toList());

    return ResponseEntity.ok(new SignInResponse(jwt, userDetails.getId(),
            userDetails.getUsername(), userDetails.getEmail(), userDetails.getLoginCount(), roles));
  }

  @PostMapping("/change-password")
  public ResponseEntity<String> changePassword(@RequestBody RequestChangePassword requestChangePassword) throws Exception {

    User user = new User();
    user.setId(requestChangePassword.getUserId());
    user.setPassword(requestChangePassword.getOldPassword());

    int check = userService.changeUserPassword(user, requestChangePassword.getNewPassword());

    if(check == 1){
      return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Password changed successfully\"}");
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Password change failed\"}");
  }

//  @PutMapping("/update-login-count")
//  public ResponseEntity<?> updateLoginCount(@RequestBody UpdateLoginCountRequest request) {
//    Long userId = request.getUserId();
//    int newLoginCount = request.getNewLoginCount();
//
//    // Update the loginCount for the user with the provided userId
//
//    // Return a response indicating success or error
//    return ResponseEntity.ok("Login count updated successfully");
//  }

  @PutMapping("/update-login-count")
  public ResponseEntity<String> updateLoginCount(
          @RequestParam Long userId,
          @RequestParam int newLoginCount
  ) {
    userService.updateLoginCount(userId, newLoginCount);
    return ResponseEntity.ok("Login count updated successfully");
  }



}
