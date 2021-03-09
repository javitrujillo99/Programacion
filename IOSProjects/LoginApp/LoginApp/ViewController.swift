//
//  ViewController.swift
//  LoginApp
//
//  Created by Angela Velilla on 20/01/2021.
//

import UIKit
import FBSDKCoreKit
import FBSDKLoginKit
import AuthenticationServices

class ViewController: UIViewController       {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        //addLoginButton()
    }
    
    private func addLoginButton() {
        let loginButton = FBSDKLoginButton()
        loginButton.center = self.view.center
        self.view.addSubview(loginButton)
        
        if FBSDKAccessToken.current() != nil {
            return
        }
        
        loginButton.readPermissions = ["public_profile", "email"]
    }
    
    
    @IBAction func appleLogin(_ sender: Any) {
        let request = ASAuthorizationAppleIDProvider().createRequest()
        request.requestedScopes = [.fullName, .email]
        
        let controller = ASAuthorizationController(authorizationRequests: [request])
        controller.delegate = self
        controller.presentationContextProvider = self
        controller.performRequests()
    }
}

// MARK: - Authorization Controller Provider & Authorization Controller Delegate

extension ViewController: ASAuthorizationControllerPresentationContextProviding, ASAuthorizationControllerDelegate {
    func presentationAnchor(for controller: ASAuthorizationController) -> ASPresentationAnchor {
        return self.view.window!
    }
    
    func authorizationController(controller: ASAuthorizationController, didCompleteWithAuthorization authorization: ASAuthorization) {
        guard let appleIDCredentials = authorization.credential as? ASAuthorizationAppleIDCredential else {
            return
        }
        
        let userIdentifier = appleIDCredentials.user
        let fullName = appleIDCredentials.fullName
        let email = appleIDCredentials.email
        
        print("\(userIdentifier), \(fullName), \(email)")
    }
    
    
}

