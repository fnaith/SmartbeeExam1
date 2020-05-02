import React from 'react';
import TextField from '@material-ui/core/TextField';

import global_data from '../../store/global_data';

interface Props {
  index: number;
}

function ClientInfoEmail(props: Props) {
  const { index } = props;

  const onChange: any = (event: any) => {
    const input: string = event.target.value;

    global_data.clientInfos[index].email = input;
  };

  return (
    <TextField id={'client-info-email-' + index} label="Email"
      defaultValue={global_data.clientInfos[index].email} margin="dense" onChange={onChange}/>
  );
}

export default ClientInfoEmail;
