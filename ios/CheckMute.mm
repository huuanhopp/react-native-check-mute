#import "CheckMute.h"
#import "AVFAudio/AVAudioSession.h"

#ifdef RCT_NEW_ARCH_ENABLED
#import "RNCheckMuteSpec.h"
#endif

@implementation CheckMute
RCT_EXPORT_MODULE()

// Example method
// See // https://reactnative.dev/docs/native-modules-ios
RCT_EXPORT_METHOD(getCurrentVolume: (RCTPromiseResolveBlock) resolve rejecter:(RCTPromiseRejectBlock)reject)
{
  [[AVAudioSession sharedInstance] setActive:YES error:nil];
  float vol = [[AVAudioSession sharedInstance] outputVolume];
  resolve(@(vol * 100));
}

RCT_EXPORT_METHOD(isMute: (RCTPromiseResolveBlock) resolve rejecter:(RCTPromiseRejectBlock)reject)
{
  [[AVAudioSession sharedInstance] setActive:YES error:nil];
  float vol = [[AVAudioSession sharedInstance] outputVolume];
  bool isMute = vol == 0 ? true : false;
  resolve(@(isMute));
}

// Don't compile this code when we build for the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeCheckMuteSpecJSI>(params);
}
#endif

@end
