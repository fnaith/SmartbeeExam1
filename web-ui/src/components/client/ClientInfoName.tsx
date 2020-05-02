import React from 'react';
import TextField from '@material-ui/core/TextField';

import global_data from '../../store/global_data';

interface Props {
  index: number;
}

function ClientInfoName(props: Props) {
  const { index } = props;

  const onChange: any = (event: any) => {
    const input: string = event.target.value;

    global_data.clientInfos[index].name = input;
  };

  return (
    <TextField id={'client-info-name-' + index} label="Name"
      defaultValue={global_data.clientInfos[index].name} margin="dense" onChange={onChange}/>
  );
}

export default ClientInfoName;
