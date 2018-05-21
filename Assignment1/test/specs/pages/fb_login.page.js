"use strict";
const b = browser

class FbLogin{

  get mailid()  { return b.element('#email.inputtext') }
  get password()  { return b.element('#pass.inputtext') }
  get loginBtn()  { return b.element('#u_0_2') }
}
module.exports = new FbLogin()
