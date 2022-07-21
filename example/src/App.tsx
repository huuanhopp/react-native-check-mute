import * as React from 'react';

import { StyleSheet, View, Text, TouchableOpacity } from 'react-native';
import { isMute } from 'react-native-check-mute';

export default function App() {
  const [result, setResult] = React.useState<boolean | undefined>();

  async function getMute() {
    let muted = await isMute();
    setResult(muted);
  }
  React.useEffect(() => {
    getMute();
  }, []);

  console.log(result)

  return (
    <View style={styles.container}>
      <Text>Result: {result?.toString()}</Text>
      <TouchableOpacity onPress={getMute}>
        <Text>Gfgdf</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
