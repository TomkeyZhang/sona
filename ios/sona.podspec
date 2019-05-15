#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html
#
Pod::Spec.new do |s|
  s.name             = 'sona'
  s.version          = '0.0.1'
  s.summary          = 'sona makes possible using umeng push in flutter.'
  s.description      = <<-DESC
sona makes possible using umeng push in flutter.
                       DESC
  s.homepage         = 'http://example.com'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Your Company' => 'email@example.com' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.public_header_files = 'Classes/public/*.h'
  s.static_framework = true
  s.dependency 'Flutter'
  s.dependency 'GTSDK'


  s.ios.deployment_target = '8.0'
end

