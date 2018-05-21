"use strict";
const b = browser

class FbSearch{

  get searchText()  { return b.element('._1frb') }
  get enterText()  { return b.element('._1frb') }
  get searchBtn()  { return b.element('._42ft._4jy0._4w98._4jy3._517h._51sy') }
  get addBtn()  { return b.element('#u_1c_4.FriendButton:nth-child(1)') }
}
module.exports = new FbSearch()
