        const CustomReporter = require('./reporter/my.custom.reporter')
        exports.config = {

            specs: [
                './test/specs/fb/*.js'
            ],
            allScriptsTimeout: 120000,
            getPageTimeout: 30000,

            capabilities: [
            {
                 browserName: 'chrome'
                chromeOptions: {
                            args: [
            '--incognito',
            'disable-extensions',
            '--start-fullscreen',
            'show-fps-counter=true',
            '--headless'
            // '--user-data-dir=Google/Chrome'
          ]

                        },
            }
            ],

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
