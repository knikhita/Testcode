const CustomReporter = require('./reporter/my.custom.reporter')
exports.config = {

    specs: [
        './test/specs/fb/*.js'
    ],
    capabilities: [{
        chromeOptions: {
                    "args": [
                        "window-size=1400,768",
                    ],
                },
        browserName: 'chrome'
    }],

    logLevel: 'silent',
    coloredLogs: true,
    screenshotPath: 'errorShots',
    baseUrl: process.env.URL,
    waitforTimeout: 300000,
    framework: 'mocha',

    reporters: [CustomReporter.reporter, 'dot'],
    reporterOptions: {
        outputDir: './'
    }

    onComplete: function() {
      

      reporterOptions : 'mentioned',
      CustomReporter : process.env.URL 
    }
};
