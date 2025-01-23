# Mockito useJUnitPlatform issues reproducer project

Here is a project that reproduces the issue with Mockito (3) when useJUnitPlatform is used. I couldn't reproduce running the tests without the useJUnitPlatform, as tests weren't discovered. Applying useJUnitPlatform is the only way to run the tests for me, so I can't compare the behavior exactly, but when I run the tests with useJUnitPlatform, I got the same error (prior to [upgrading to Mockito 5](https://github.com/ribafish/reproducers/commit/d568b3b246b537f598628d93bbe826eb2ba35d07)) of mocks not being injected into the test class. 

